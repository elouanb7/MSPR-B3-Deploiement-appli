<script setup>
import { RouterView } from "vue-router";
import NavBar from "@/components/NavbarComponent.vue";
import ImagesPlant from "@/components/ImagesPlantComponent.vue";
</script>

<template>
  <link
    href="https://fonts.googleapis.com/css?family=Montserrat"
    rel="stylesheet"
  />
  <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
  <component
    :is="'script'"
    type="application/javascript"
    src="https://kit.fontawesome.com/edc8d5fc95.js"
    crossorigin="anonymous"
  >
  </component>

  <header></header>
  <NavBar />
  <ImagesPlant />
  <RouterView />
</template>

<style scoped></style>