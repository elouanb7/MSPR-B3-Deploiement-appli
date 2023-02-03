<template>
  <div class="card">
    <!--    <RouterLink :to="'/plante/' + plant.id + '/detail'">-->
    <RouterLink :to="{ name: 'plante', params: { id: plant.id } }">
      <div class="container">
        <div class="card-image">
          <img
            src="https://monjardindidees.fr/wp-content/uploads/2022/02/philodendron-678x381.jpg"
          />
        </div>
        <div class="card-title">{{ plant.name }}</div>
      </div>
    </RouterLink>
  </div>
</template>

<style scoped>
.card {
  width: 300px;
  margin: 30px;
  background: #ffffff;
  box-shadow: 0px 0px 70px rgba(19, 59, 83, 0.15);
  border-radius: 10px;
  color: white;
}

.card-image {
  position: absolute;
  box-shadow: 0px 0px 70px rgba(19, 59, 83, 0.15);
  border-radius: 10px;
  width: 300px;
  height: 250px;
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
}

.card-image img {
  position: absolute;
  object-fit: cover;
}

.container {
  height: 250px;
  position: relative;
  display: flex;
  justify-content: flex-end;
  flex-direction: column;
  align-items: flex-end;
}

.card-title {
  text-align: center;
  text-transform: uppercase;
  position: absolute;
  margin: 20px;
  font-size: 18px;
  color: white;
}

.card-button button {
  background: #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 5px;
  color: white;
}
</style>

<script>
// import axios from "axios";
//
// const PLANTS_API_BASE_URL = "http://localhost:8080/api/plants";

export default {
  name: "PlantCard",
  props: ["plant"],
  // data() {
  //   return {
  //     plants: [],
  //   };
  // },
  // methods: {
  //   getPlants() {
  //     axios.get(PLANTS_API_BASE_URL).then((response) => {
  //       console.log(response.data);
  //       this.plants = response.data;
  //     });
  //   },
  // },
  // created() {
  //   this.getPlants();
  // },
};

// class PlantsService {
//   getPlants() {
//     let result = axios.get(PLANTS_API_BASE_URL);
//     console.log(result);
//     return result;
//   }
// }
</script>
