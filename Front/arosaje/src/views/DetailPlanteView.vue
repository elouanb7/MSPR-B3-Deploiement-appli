<template>
  <div class="box">
    <div class="All-info"></div>

    <div class="plantstitle">
      <h2>
        <i>{{ plant.latinName }}</i>
      </h2>
      <h1>{{ plant.name }}</h1>
    </div>

    <div class="infos">
      <h3 class="label-detail">Description</h3>
      <p>
        {{ plant.description }}
      </p>

      <h3 class="label-detail">Espèce</h3>
      <p>
        {{ plant.species }}
      </p>

      <h3 class="label-detail">Fréquence d'arrosage par jour</h3>
      <p>{{ plant.wateringFrequency }} fois</p>

      <h3 class="label-detail">Nombre d'heure exposé au soleil par jour</h3>
      <p>{{ plant.sunExposure }} heure(s)</p>

      <h3 class="label-detail">Nom du botaniste</h3>
      <p>{{ plant.botanist.firstName }} {{ plant.botanist.lastName }}</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

const PLANTS_API_BASE_URL = "http://localhost:8080/api/plant";

export default {
  name: "DetailPlanteView",
  props: ["id"],
  components: {},
  data() {
    return {
      plant: [],
    };
  },
  methods: {
    getPlant() {
      axios.get(PLANTS_API_BASE_URL + "/" + this.plantId).then((response) => {
        this.plant = response.data;
      });
    },
  },
  computed: {
    plantId() {
      return this.$route.params.id;
    },
  },
  created() {
    this.getPlant();
  },
};
</script>

<style scoped>
.infos {
  max-width: 458px;
  width: 100%;
}

.label-detail {
  font-weight: 400;
  font-size: 18px;
  line-height: 27px;
  color: #171616;
  margin-top: 15px;
}

p {
  font-weight: 400;
  font-size: 16px;
  line-height: 24px;
  color: #515151;
  border-bottom: 1px solid #3d3b36;
  padding-bottom: 15px;
  margin-top: 15px;
}

.box {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.plantstitle {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  margin-top: 175px;
}

.All-info {
  position: relative;
  max-width: 422px;
  width: 100%;
  height: 422px;
  background: #c5ffdc;
  filter: blur(125px);
  opacity: 0.25;
}
</style>
