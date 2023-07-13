<template>
  <form @submit="validateAndSubmit">
    <div id="plant">
      <h1>Ajout d'une plante</h1>

      <div class="informations">
        <fieldset class="form-group">
          <input
            type="text"
            placeholder="Description"
            class="saisie-texte"
            v-model="description"
          />
        </fieldset>

        <fieldset class="form-group">
          <input
            type="text"
            placeholder="Nom"
            class="saisie-texte"
            v-model="name"
          />
        </fieldset>

        <fieldset class="form-group">
          <input
            type="text"
            placeholder="Nom Latin"
            class="saisie-texte"
            v-model="latinName"
          />
        </fieldset>

        <fieldset class="form-group">
          <input
            type="text"
            placeholder="Espèce"
            class="saisie-texte"
            v-model="species"
          />
        </fieldset>

        <fieldset class="form-group">
          <input
            type="number"
            placeholder="Exposition au soleil (en h)"
            class="saisie-texte"
            min="0"
            v-model="sunExposure"
          />
        </fieldset>

        <fieldset class="form-group">
          <input
            type="number"
            placeholder="Fréquence d'arosage (nombre de fois /j)"
            class="saisie-texte"
            min="0"
            v-model="wateringFrequency"
          />
        </fieldset>

        <button type="submit" class="save-button">Sauvegarder</button>
      </div>
    </div>
  </form>
</template>

<script>
import axios from "axios";

import { API_BASE_URL } from "@/constants.js";
import { useUserStore } from "@/stores/user";

export default {
  name: "PlantForm.vue",
  data() {
    return {
      plant: null,
      userStore: useUserStore(),
    };
  },
  methods: {
    validateAndSubmit() {
      let plant = {
        description: this.description,
        latinName: this.latinName,
        name: this.name,
        species: this.species,
        sunExposure: this.sunExposure,
        wateringFrequency: this.wateringFrequency,
        image: null,
      };
      this.addPlant(plant, this.userStore.id);
    },
    addPlant(plant, botanistId) {
      console.log(API_BASE_URL);
      axios
        .post(`${API_BASE_URL}/plant/add?botanistId=${botanistId}`, plant)
        .then((response) => {
          this.plant = response.data;
        });
    },
  },
};
</script>

<style scoped>
fieldset {
  border: none;
  font-weight: 400;
  font-size: 16px;
  line-height: 24px;
  color: #515151;
}

input {
  margin: 10px;
}

h1 {
  font-size: 45px;
  text-align: center;
}

#plant {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 120px;
}

.informations {
  max-width: 600px;
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
  margin-top: 50px;
}

.saisie-texte {
  width: 210px;
  height: 60px;
  background: #fafafa;
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

.save-button {
  width: 210px;
  height: 60px;
  background: #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 30px;
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  text-align: center;
  color: #fafafa;
  cursor: pointer;
  margin: 15px;
}
</style>
