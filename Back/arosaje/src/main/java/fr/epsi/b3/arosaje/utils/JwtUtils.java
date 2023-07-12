package fr.epsi.b3.arosaje.utils;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import fr.epsi.b3.arosaje.bo.User;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.springframework.stereotype.Component;

import java.io.Reader;
import java.io.StringReader;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import java.nio.file.Files;
import java.nio.file.Paths;




@Component
public class JwtUtils {
    private RSAPublicKey rsaPublicKey;
    private RSAPrivateKey rsaPrivateKey;
    private String rsaPrivateKeyId;
    private static final long EXPIRATION_TIME_MS = 3600000; // 1 hour

    public JwtUtils() {
        // Load the RSA private key and private key ID
        loadRSAKey();
    }

    private void loadRSAKey() {
        try {

            String rootPath = System.getProperty("user.dir");
            String publicKeyFilePath = rootPath + "/jwtkeys/jwtRSA256-public.pem";
            String privateKeyFilePath = rootPath + "/jwtkeys/jwtRSA256-private.pem";

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            // Load RSA public key from file
            String publicKeyString = Files.readString(Paths.get(publicKeyFilePath));
            keyToBytes(publicKeyString);
            byte[] publicKeyBytes = keyToBytes(publicKeyString);
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
            // Load RSA private key from file
            String privateKeyString = Files.readString(Paths.get(privateKeyFilePath));
            byte[] privateKeyBytes = keyToBytes(privateKeyString);
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            rsaPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);

            rsaPrivateKeyId = UUID.randomUUID().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] keyToBytes(String key) {
        try (
                Reader reader = new StringReader(key);
                PemReader pemReader = new PemReader(reader)
        ) {
            PemObject pemObject = pemReader.readPemObject();
            return pemObject.getContent();

        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

    public JwkProvider getJwkProvider() {
        return new JwkProviderBuilder("https://samples.auth0.com/")
                .cached(10, 24, TimeUnit.HOURS)
                .rateLimited(10, 1, TimeUnit.MINUTES)
                .build();
    }

    public RSAKeyProvider getRSAKeyProvider() {
        JwkProvider jwkProvider = getJwkProvider();
        return new RSAKeyProvider() {
            @Override
            public RSAPublicKey getPublicKeyById(String kid) {
                try {
                    Jwk jwk = jwkProvider.get(kid);
                    return (RSAPublicKey) jwk.getPublicKey();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            public RSAPrivateKey getPrivateKey() {
                return rsaPrivateKey;
            }

            @Override
            public String getPrivateKeyId() {
                return rsaPrivateKeyId;
            }
        };
    }

    public Algorithm getAlgorithm() {
        RSAKeyProvider keyProvider = getRSAKeyProvider();
        return Algorithm.RSA256(keyProvider);
    }

    public RSAPublicKey getRSAPublicKey() {
        return rsaPublicKey;
    }


    public String createJwtToken(User user) {
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            Date expiryDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME_MS);

            return JWT.create()
                    .withIssuer("auth0")
                    .withClaim("userId", user.getId())
                    .withExpiresAt(expiryDate)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            // Handle exception if JWT creation fails
            exception.printStackTrace();
            return null;
        }
    }

    public boolean verifyJwtToken(String token) {
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            // Handle exception if JWT verification fails
            exception.printStackTrace();
            return false;
        }
    }

    public Integer extractUserIdFromToken(String token) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            System.out.println(decodedJWT.getClaim("userId").asInt());
            return decodedJWT.getClaim("userId").asInt();
        } catch (JWTVerificationException exception) {
            // Handle exception if JWT decoding fails
            exception.printStackTrace();
            return null;
        }
    }
}