<template>
  <form @submit="validateAndSubmit">
    Localisation
    <fieldset class="form-group">
      <label>Ville</label>
      <input type="text" class="form-control" v-model="city" />
    </fieldset>
    <fieldset class="form-group">
      <label>Pays</label>
      <input type="text" class="form-control" v-model="country" />
    </fieldset>
    <fieldset class="form-group">
      <label>Rue</label>
      <input type="text" class="form-control" v-model="street" />
    </fieldset>
    <fieldset class="form-group">
      <label>Code Postal</label>
      <input type="number" class="form-control" v-model="zipCode" />
    </fieldset>
    <button type="submit" class="save-button">Save</button>
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
</style>
