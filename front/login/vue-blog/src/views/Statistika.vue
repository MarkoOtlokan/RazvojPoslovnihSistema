<template>
  <div class="container">
    <label for="title">Najveci potrosaci:</label>
    <div class="posts" v-if="BestCustomers">
      <ul>
        <li v-for="sale in BestCustomers" :key="sale.id">
          <div id="sale-div">
            <p>{{sale.firstName + " " +sale.lastName
              + " | potrosio " + sale.spend}}</p>
          </div>
        </li>
      </ul>
    </div>
    <div v-else>Ne postoji istorija trgovanja</div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
//import vueSelect from 'vue-select'

export default {
  name: "Statistika",
  components: {},
  data() {
    return {
      form: {
        title: "",
        write_up: "",
      },
    };
  },
  created: function() {
    this.GetBestCustomers()
  },
  computed: {
    ...mapGetters({ BestCustomers: "StateBestCustomers", User: "StateUser" }),
  },
  methods: {
    ...mapActions(["GetBestCustomers"]),
  },
};
</script>
<style scoped>
* {
  box-sizing: border-box;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

button[type="submit"] {
  background-color: #4caf50;
  color: white;
  padding: 12px 20px;
  cursor: pointer;
  border-radius: 30px;
  margin: 10px;
}

button[type="submit"]:hover {
  background-color: #45a049;
}

input {
  width: 15%;
  margin: 15px;
  border: 0;
  box-shadow: 0 0 15px 4px rgba(0, 0, 0, 0.06);
  padding: 10px;
  border-radius: 30px;
}

textarea {
  width: 75%;
  resize: vertical;
  padding: 15px;
  border-radius: 15px;
  border: 0;
  box-shadow: 0 0 15px 4px rgba(0, 0, 0, 0.06);
  height: 150px;
  margin: 15px;
}

ul {
  list-style: none;
}

#sale-div {
  border: 3px solid #000;
  width: 500px;
  margin: auto;
  margin-bottom: 5px;
}
</style>
