<template>
  <div class="box">
    <div class="background"></div>

    <div class="plantstitle">
      <h2>
        <i>{{ plant.latinName }}</i>
      </h2>
      <h1>{{ plant.name }}</h1>
      {{ plantId }}
    </div>
  </div>
</template>

<script>
import axios from "axios";

const PLANTS_API_BASE_URL = "http://localhost:8080/api/plants";

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

<style scoped></style>
