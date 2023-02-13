<template>
  <form @submit="validateAndSubmit" class="form">
    <div id="demande">
      <h1>Ajout d'une demande</h1>

      <div class="informations">
        <fieldset class="form-group">
          <input
            type="text"
            placeholder="Description"
            class="saisie-texte"
            v-model="description"
          />
        </fieldset>

        <!--        <fieldset class="form-group">
          <input
            type="text"
            placeholder="Plante"
            class="saisie-texte"
            v-model="plant"
          />
        </fieldset>-->

        <fieldset class="form-group">
          <input
            type="date"
            placeholder="Date de début"
            class="saisie-texte"
            v-model="beginDate"
          />
        </fieldset>

        <fieldset class="form-group">
          <input
            type="date"
            placeholder="Date de fin"
            class="saisie-texte"
            v-model="endDate"
          />
        </fieldset>
        <fieldset class="form-group">
          <select class="select-plant" v-model="plantSelected">
            <option
              v-for="(plant, index) in plants"
              :key="index"
              :value="plant.id"
            >
              {{ plant.name }}
            </option>
          </select>
        </fieldset>
        <fieldset class="form-group">
          <label>Images</label>
          <input type="file" class="form-control" @change="onImageChange" />
        </fieldset>
        <button type="submit" class="save-button">Save</button>
      </div>
    </div>
  </form>
</template>

<script>
import axios from "axios";
import { API_BASE_URL } from "@/constants.js";
const PLANTS_API_BASE_URL = "http://localhost:8080/api/plants";
export default {
  name: "AskForm.vue",
  data() {
    return {
      ask: null,
      images: [],
      locationId: "",
      plants: [],
    };
  },
  created() {
    this.locationId = parseInt(this.$route.params.locationId);
    this.getPlants();
  },
  methods: {
    getPlants() {
      axios.get(PLANTS_API_BASE_URL).then((response) => {
        this.plants = response.data;
      });
    },
    validateAndSubmit() {
      let ask = {
        description: this.description,
        plant: this.plantSelected,
        location: this.locationId,
        beginDate: this.beginDate,
        endDate: this.endDate,
        images: this.images,
      };
      this.postAsk(ask, 2, this.plantSelected, this.locationId);
    },
    postAsk(ask, ownerId, plantId, locationId) {
      axios
        .post(
          `${API_BASE_URL}/ask/add?ownerId=${ownerId}&plantId=${plantId}&locationId=${locationId}`,
          ask
        )
        .then((response) => {
          this.ask = response.data;
          console.log(this.ask);
        });
    },
    onImageChange(event) {
      this.image.push(event.target.files[0]);
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

#demande {
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
