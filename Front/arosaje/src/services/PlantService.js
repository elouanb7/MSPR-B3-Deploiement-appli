/*import Api from "./api";
import axios from "axios";
import { API_BASE_URL } from "@/constants.js";

export default {
  getPlantList() {
    return Api().get("/plants/");
  },
  getPlant(id) {
    return Api().get("/plant/" + id);
  },
  addPlant(plant, botanistId) {
    return axios
      .post(`${API_BASE_URL}/plant/add?botanistId=${botanistId}`, plant)
      .then((response) => {
        return response.data;
      });
  },
  /!*  addPlant(plant, botanistId) {
    return Api().post(`/plant/add?botanistId=${botanistId}`, plant);
  },*!/
};*/
