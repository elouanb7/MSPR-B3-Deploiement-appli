import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "accueil",
      component: () => import("../views/HomeView.vue"),
    },
    {
      path: "/connexion",
      name: "connexion",
      component: () => import("../views/ConnexionView.vue"),
    },
    {
      path: "/inscription",
      name: "inscription",
      component: () => import("../views/InscriptionView.vue"),
    },
    {
      path: "/plantes",
      name: "plantes",
      component: () => import("../views/PlantesView.vue"),
    },
    {
      path: "/plante/:id/detail",
      name: "plante",
      component: () => import("../views/DetailPlanteView.vue"),
    },
    {
      path: "/plante/ajout",
      name: "addPlante",
      component: () => import("../components/Form/PlantForm.vue"),
    },
    {
      path: "/carte",
      name: "carte",
      component: () => import("../views/CarteView.vue"),
    },
    {
      path: "/demande/:id/detail",
      name: "demande",
      component: () => import("../views/DetailDemandeView.vue"),
    },
    {
      path: "/demande/ajout",
      name: "addDemande",
      component: () => import("../components/Form/AskForm.vue"),
    },
    {
      path: "/location/ajout",
      name: "addLocation",
      component: () => import("../components/Form/LocationForm.vue"),
    },
  ],
});

export default router;
