<template>
  <form @submit.prevent="validateAndSubmit">
    <div id="location">
      <h1>Ajout de la localisation</h1>
      <div class="informations">
        <fieldset class="form-group">
          <input
            type="text"
            placeholder="Ville"
            class="saisie-texte"
            v-model="city"
          />
        </fieldset>

        <fieldset class="form-group">
          <input
            type="text"
            placeholder="Pays"
            class="saisie-texte"
            v-model="country"
          />
        </fieldset>

        <fieldset class="form-group">
          <input
            type="text"
            placeholder="Rue"
            class="saisie-texte"
            v-model="street"
          />
        </fieldset>

        <fieldset class="form-group">
          <input
            type="number"
            placeholder="Code Postal"
            class="saisie-texte"
            v-model="zipCode"
          />
        </fieldset>
      </div>

      <button type="submit" class="save-button">Sauvegarder</button>
    </div>
  </form>
</template>

<script>
import axios from "axios";
import { API_BASE_URL } from "@/constants";
import router from "@/router";

export default {
  name: "LocationForm.vue",
  data() {
    return {
      location: null,
    };
  },
  methods: {
    validateAndSubmit() {
      let location = {
        city: this.city,
        country: this.country,
        street: this.street,
        zipCode: this.zipCode,
      };
      this.postLocation(location);
    },
    postLocation(location) {
      axios.post(`${API_BASE_URL}/location/add`, location).then((response) => {
        this.location = response.data;
        router.push({
          name: "addDemande",
          params: { locationId: response.data.id },
        });
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

#location {
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