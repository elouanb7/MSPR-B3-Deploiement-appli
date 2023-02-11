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
      <input type="date" class="form-control" v-model="street" />
    </fieldset>
    <fieldset class="form-group">
      <label>Code Postal</label>
      <input type="date" class="form-control" v-model="zipCode" />
    </fieldset>
  </form>
</template>

<script>
export default {
  name: "LocationForm.vue",
  data() {
    return {
      location: null,
    };
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
