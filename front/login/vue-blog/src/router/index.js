import Vue from "vue";
import VueRouter from "vue-router";
import store from "../store";
import Home from "../views/Home.vue";
import Login from "../views/Login";
import AddClients from "../views/DodajKlijenta";
import AddProducts from "../views/DodajProizvod";
import Prodaja from "../views/Prodaja";
import Statistika from "../views/Statistika";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
    meta: { requiresAuth: true },
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
    meta: { guest: true },
  },
  {
    path: "/addClient",
    name: "AddClient",
    component: AddClients,
    meta: { requiresAuth: true },
  },
  {
    path: "/addProduct",
    name: "AddProduct",
    component: AddProducts,
    meta: { requiresAuth: true },
  },
  {
    path: "/sale",
    name: "Prodaja",
    component: Prodaja,
    meta: { requiresAuth: true },
  },
  {
    path: "/stat",
    name: "Statistika",
    component: Statistika,
    meta: { requiresAuth: true },
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach((to, from, next) => {
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    if (store.getters.isAuthenticated) {
      next();
      return;
    }
    next("/login");
  } else {
    next();
  }
});

router.beforeEach((to, from, next) => {
  if (to.matched.some((record) => record.meta.guest)) {
    if (store.getters.isAuthenticated) {
      next("/");
      return;
    }
    next();
  } else {
    next();
  }
});

export default router;
