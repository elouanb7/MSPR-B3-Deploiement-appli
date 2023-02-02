<template>
  <div id="inscription">
    <h1>Inscription</h1>

    <h3>informations personnelles:</h3>

    <input class="saisieTexte" placeholder="Nom" />
    <input class="saisieTexte" placeholder="Prénom" />

    <input type="date" class="saisieTexte" placeholder="Date de naissance" />
    Genre:
    <select type="checkbox">
      <option value="Homme">Homme</option>
      <option value="Femme">Femme</option>
      <option value="Autre">Autre</option>
    </select>

    <h3>Informations de connexion</h3>

    <input class="saisieTexte" placeholder="Email" />
    <input class="saisieTexte" placeholder="Nom d'utilisateur" />

    <input class="saisieTexte" placeholder="Mot de passe" type="password" />
    <input
      class="saisieTexte"
      placeholder="Confirmer le mot de passe"
      type="password"
    />
    <button class="boutonInscription">S'inscrire</button>
    <p>
      <router-link to="/connexion">Vous avez déja un compte ?</router-link>
    </p>
  </div>
</template>

<script></script>

<style scoped>
.saisieTexte {
  border-color: rgb(3, 34, 76);
  margin: 10px;
  border-radius: 10px;
  width: 200px;
  height: 30px;
}

.boutonInscription {
  border-color: rgb(3, 34, 76);
  margin: 10px;
  border-radius: 10px;
  width: 200px;
  height: 30px;

  background-color: rgb(3, 34, 76);
  color: white;
  font-weight: bold;
}

#inscription {
  font-family: "Roboto", sans-serif;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
