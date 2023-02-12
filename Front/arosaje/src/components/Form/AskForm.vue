<template>
  <div class="box-form">
    <h2 class="title-form">Demande de garde</h2>
    <div class="container-form">
      <form @submit="validateAndSubmit" class="form">
        <fieldset class="form-group">
          <label>Description</label>
          <input type="text" class="form-control" v-model="description" />
        </fieldset>
        <fieldset class="form-group">
          <label>Plante</label>
          <input type="text" class="form-control" v-model="plant" />
        </fieldset>
        <fieldset class="form-group">
          <label>Date de début</label>
          <input type="date" class="form-control" v-model="beginDate" />
        </fieldset>
        <fieldset class="form-group">
          <label>Date de fin</label>
          <input type="date" class="form-control" v-model="endDate" />
        </fieldset>
        <button type="submit" class="save-button">Save</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { API_BASE_URL } from "@/constants.js";

export default {
  name: "AskForm.vue",
  data() {
    return {
      ask: null,
    };
  },
  methods: {
    validateAndSubmit() {
      let ask = {
        description: this.description,
        plant: this.plant,
        location: this.location,
        beginDate: this.beginDate,
        endDate: this.endDate,
        images: null,
      };
      this.postAsk(ask, 2);
    },
    postAsk(ask, ownerId) {
      axios
        .post(`${API_BASE_URL}/ask/add?ownerId=${ownerId}`, ask)
        .then((response) => {
          this.ask = response.data;
          console.log(this.ask);
        });
    },
  },
};
</script>

<style scoped>
.box-form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container-form {
  max-width: 450px;
  padding: 0 20px;
  margin-top: 275px;
}

.title-form {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  margin-top: 175px;
}

.form {
  position: relative;
  max-width: 422px;
  width: 100%;
  height: 422px;
}

fieldset {
  border: none;
  font-weight: 400;
  font-size: 16px;
  line-height: 24px;
  color: #515151;
  border-bottom: 1px solid #3d3b36;
  padding-bottom: 15px;
  margin-top: 15px;
}

input {
  margin: 10px;
}

.save-button {
  width: 190px;
  height: 50px;
  background: #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 30px;
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  text-align: center;
  color: #fafafa;
  margin: 15px;
}
</style>
