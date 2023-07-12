/**
 * api.js
 * This file holds the base url(s) for the API used by
 * the webApp vue template. In this case, we assume only
 * one baseUrl and json data transmission.
 *
 */

// import Vue from 'vue';
import axios from "axios";
import { API_BASE_URL } from "@/constants.js";
// import router from "./../routes";
// import toast from "./../toast";

//We create an instance of axios
const axiosAPI = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

export default () => {
  axiosAPI.interceptors.response.use(
    (response) => {
      console.log("good boi!");
      return response;
    },
    (error) => {
      return Promise.reject(error);
    }
  );
  return axiosAPI;
};
