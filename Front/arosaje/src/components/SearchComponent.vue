<script setup>
</script>

<template>
  <div class="SearchBar">
      <h3>Trouver des plantes à proximité</h3>

      <div class="buttons">
        <select>
          <option value="France">FRANCE</option>
          <option value="Allemagne">ANGLETERRE</option>
          <option value="Espagne">ESAPGNE</option>
          <option value="Portugal">PORTUGAL</option>
          <option value="Belgique">BELGIQUE</option>
          <option value="Allemagne">ALLEMAGNE</option>
          <option value="Italie">ITALIE</option>
        </select>

        <input type="text" placeholder="Entrez la ville">

        <button>Chercher des plantes</button>
      </div>
    </div>
</template>

<style>
.SearchBar {
  max-width: 970px;
  width: 100%;
   background: #FFFFFF;
  box-shadow: 0px 0px 70px rgba(19, 59, 83, 0.15);
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  padding: 30px;
}

.buttons {
  display: flex;
  flex-direction: row;
}

h3 {
  margin: 5px;
}

select {
  max-width: 340px;
  width: 100%;
  height: 60px;
  background: #FFFFFF;
  border: 1px solid #060825;
  border-radius: 5px;
  font-family: 'Montserrat';
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  color: #060825;
  padding: 15px;
  margin: 5px;
}

input {
  max-width: 340px;
  min-width: 150px;
  width: 100%;
  height: 60px;
  background: #FFFFFF;
  border: 1px solid #060825;
  border-radius: 5px;
  font-family: 'Montserrat';
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  color: #060825;
  padding: 15px;
  margin: 5px;
}

button {
  max-width: 210px;
  width: 100%;
  height: 60px;
  background: #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 5px;
  font-family: 'Montserrat';
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  color: #FFFFFF;
  margin: 5px;
}

@media screen and (max-width: 1024px) {
  .buttons {
    display: flex;
    flex-direction: column;
  }
}
</style>