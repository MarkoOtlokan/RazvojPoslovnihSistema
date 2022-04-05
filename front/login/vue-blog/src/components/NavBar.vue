<template>
  <div id="nav">
    <router-link to="/">Pocetni</router-link> |
    <router-link to="/addClient">Dodaj Klijenta</router-link> |
    <router-link to="/addProduct">Dodaj Proizvod</router-link> |
    <router-link to="/sale">Prodaja</router-link> |
    <router-link to="/stat">Statistika</router-link> |
    <span v-if="isLoggedIn">
      <a @click="logout">Odjava</a>
    </span>
    <span v-else>
      <router-link to="/login">Login</router-link>
    </span>
  </div>
</template>
<script>
export default {
  name: "NavBar",
  computed: {
    isLoggedIn: function() {
      return this.$store.getters.isAuthenticated;
    },
  },
  methods: {
    async logout() {
      await this.$store.dispatch("LogOut");
      this.$router.push("/login");
    },
  },
};
</script>

<style>
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

a:hover {
  cursor: pointer;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
