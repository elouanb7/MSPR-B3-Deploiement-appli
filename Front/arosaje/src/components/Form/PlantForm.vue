<template>
  <div>
    <h3>Plante</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <fieldset class="form-group">
          <label>Description</label>
          <input type="text" class="form-control" v-model="description" />
        </fieldset>
        <fieldset class="form-group">
          <label>Nom</label>
          <input type="text" class="form-control" v-model="name" />
        </fieldset>
        <fieldset class="form-group">
          <label>Nom Latin</label>
          <input type="text" class="form-control" v-model="latinName" />
        </fieldset>
        <fieldset class="form-group">
          <label>Espèce</label>
          <input type="text" class="form-control" v-model="species" />
        </fieldset>
        <fieldset class="form-group">
          <label>Exposition au soleil (en h)</label>
          <input type="number" class="form-control" v-model="sunExposure" />
        </fieldset>
        <fieldset class="form-group">
          <label>Fréquence d'arosage (nombre de fois / j)</label>
          <input
            type="number"
            class="form-control"
            v-model="wateringFrequency"
          />
        </fieldset>
        <button type="submit">Save</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

import Constants from "@/components/constants";
export default {
  name: "PlantForm.vue",
  data() {
    return {
      plant: null,
    };
  },
  methods: {
    validateAndSubmit() {
      let object = {
        description: this.description,
        latinName: this.latinName,
        name: this.name,
        species: this.species,
        sunExposure: this.sunExposure,
        wateringFrequency: this.wateringFrequency,
        image: null,
      };
      this.postPlant(object, 2);
    },
    postPlant(plant, botanistId) {
      axios
        .post(
          `${Constants.API_BASE_URL}/plant/add?botanistId=${botanistId}`,
          plant
        )
        .then((response) => {
          this.plant = response.data;
          console.log(this.plant);
        });
    },
  },
};
</script>

<style scoped></style>
