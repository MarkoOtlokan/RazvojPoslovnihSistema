<template>
  <div class="home">
    <div v-if="User">
      <p>Korisnik: {{ User }}</p>
    </div>
    <h1>Aplikacija za vodjenje evidencije poslovanja</h1>
    <h3>Za dodavanje novog klijenta idite u <a href="http://localhost:8081/addClient">Dodaj Klijenta</a></h3>
    <h3>Za dodavanje novog proizvoda idite u <a href="http://localhost:8081/addProduct">Dodaj Proizvod</a></h3>
    <h3>Za dodavanje novog klijenta idite u <a href="http://localhost:8081/sale">Prodaja</a></h3>
    <h3>Za statistiku trenutnog poslovanja idite u <a href="http://localhost:8081/stat">Statistika</a></h3>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "Home",
  components: {},
  computed: {
    ...mapGetters({User: "StateUser" }),
  },
};
</script>
