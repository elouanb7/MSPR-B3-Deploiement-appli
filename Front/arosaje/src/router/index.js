import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "accueil",
      component: () => import("../views/HomeView.vue"),
      meta: { title: "Accueil" },
    },
    {
      path: "/connexion",
      name: "connexion",
      component: () => import("../views/ConnexionView.vue"),
      meta: { title: "Connexion" },
    },
    {
      path: "/profil/:id",
      name: "profil",
      component: () => import("../views/ProfilView.vue"),
    },
    {
      path: "/inscription",
      name: "inscription",
      component: () => import("../views/InscriptionView.vue"),
      meta: { title: "Inscription" },
    },
    {
      path: "/plantes",
      name: "plantes",
      component: () => import("../views/PlantesView.vue"),
      meta: { title: "Liste des plantes" },
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
      meta: { title: "Ajout de plante" },
    },
    {
      path: "/carte",
      name: "carte",
      component: () => import("../views/CarteView.vue"),
      meta: { title: "Liste des demandes" },
    },
    {
      path: "/demande/:id/detail",
      name: "demande",
      component: () => import("../views/DetailDemandeView.vue"),
    },
    {
      path: "/demande/ajout/:locationId",
      name: "addDemande",
      component: () => import("../components/Form/AskForm.vue"),
      meta: { title: "Ajout de demande" },
    },
    {
      path: "/location/ajout",
      name: "addLocation",
      component: () => import("../components/Form/LocationForm.vue"),
      meta: { title: "Demande de garde" },
    },
  ],
});

router.beforeEach((to, from, next) => {
  document.title = to.meta.title;
  next();
});
export default router;
