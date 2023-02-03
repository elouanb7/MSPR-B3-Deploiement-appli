<template>
    <div id="connexion">
        <h1>Connexion</h1>

        <input class="saisie-texte" placeholder="Email" />
        <input class="saisie-texte" placeholder="Mot de passe" />

        <a href="">
            <button class="bouton-connexion">Se connecter</button>
        </a>
        <p>
            <router-link to="/inscription" class="link-to-inscription">Vous n'avez pas de compte ?</router-link>
        </p>  
    </div>
</template>

<style scoped>
.saisie-texte {
  width: 210px;
  height: 60px;
  background: #FAFAFA;
  border: 1px solid #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 30px;
  font-weight: 500;
  font-size: 12px;
  line-height: 15px;
  text-align: center;
  color: rgba(6, 8, 37, 0.5);
  margin: 15px;
}

.bouton-connexion {
  width: 210px;
  height: 60px;
  background: #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 30px;
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  text-align: center;
  color: #FAFAFA;
  margin: 15px;
}

.link-to-inscription {
  font-weight: 400;
  font-size: 14px;
  line-height: 17px;
  text-align: center;
  color: #060825;
  text-decoration: none;
  margin: 15px;
}

#connexion {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 120px;
}
</style>