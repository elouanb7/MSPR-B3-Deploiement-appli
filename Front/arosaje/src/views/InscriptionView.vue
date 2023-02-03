<template>
  <div id="inscription">
    <h1>Inscription</h1>

    <h3>Informations personnelles :</h3>

    <div class="informations">
      <input class="saisie-texte" placeholder="Nom" />
      <input class="saisie-texte" placeholder="Prénom" />

      <input type="date" class="saisie-texte" placeholder="Date de naissance" />

      <select type="checkbox" class="select-genre">
        <option value="Homme">Homme</option>
        <option value="Femme">Femme</option>
        <option value="Autre">Autre</option>
      </select>
    </div>

    <h3>Informations de connexion</h3>

    <div class="informations">
      <input class="saisie-texte" placeholder="Email" />
      <input class="saisie-texte" placeholder="Nom d'utilisateur" />

      <input class="saisie-texte" placeholder="Mot de passe" type="password" />
      <input class="saisie-texte" placeholder="Confirmer le mot de passe" type="password" />
    </div>

    <a href="">
      <button class="bouton-inscription">S'inscrire</button>
    </a>
    <p>
      <router-link to="/connexion" class="link-to-connexion">Vous avez déja un compte ?</router-link>
    </p>
  </div>
</template>

<script></script>

<style scoped>
.informations {
  max-width: 600px;
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
}

.select-genre {
  max-width: 210px;
  width: 100%;
  height: 60px;
  background: #ffffff;
  border: 1px solid #060825;
  border-radius: 5px;
  font-family: "Montserrat";
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  color: #060825;
  padding: 15px;
  margin: 5px;
}

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

.bouton-inscription {
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

.link-to-connexion {
  font-weight: 400;
  font-size: 14px;
  line-height: 17px;
  text-align: center;
  color: #060825;
  text-decoration: none;
  margin: 15px;
}

#inscription {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 120px;
}
</style>
