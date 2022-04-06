<template>
  <div class="container">
    <div v-if="User">
      <p>Korisnik: {{ User }}</p>
    </div>
    <div>
      <form @submit.prevent="submit">
        <div v-if="Clients">
          <label for="title">Klijent:</label>
          <select v-model="selectedClient">
            <option v-for="value in Clients" :key="value.id">
              {{value.id + " " + value.firstName + " " + value.lastName}}
            </option>
          </select>
        </div>
        <div v-if="Products">
          <label for="title">Proizvod:</label>
          <select v-model="selectedProduct">
            <option v-for="value in Products" :key="value.id">
              {{value.id + " " +  value.name}}
            </option>
          </select>
        </div>
        <div>
          <label for="title">Kolicina:</label>
          <input type="number" name="title" v-model="form.amount" min="1" max="5000000"/>
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
    <label for="title">Istorija:</label>
    <div class="posts" v-if="Clients">
      <ul>
        <li v-for="sale in Sales" :key="sale.id">
          <div id="sale-div">
            <p>{{sale.customer.firstName + " " +sale.customer.lastName
              + " - " + sale.article.name
              + " | količina " + sale.amount
              + " | zarada " + sale.amount * sale.article.price + "$" }}</p>
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
  name: "Prodaja",
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
    // a function to call getposts action
    this.GetClients()
    this.GetProducts()
    this.GetSales()
  },
  computed: {
    ...mapGetters({ Clients: "StateClients", User: "StateUser", Products: "StateProducts", Sales: "StateSales" }),
  },
  methods: {
    ...mapActions(["AddSale", "GetClients", "GetProducts", "GetSales"]),
    async submit() {
      try {
        this.form.customerId = parseInt(this.selectedClient.split(' ')[0])
        this.form.articleId = parseInt(this.selectedProduct.split(' ')[0])
        this.form.amount = parseInt(this.form.amount)
        await this.AddSale(this.form);
        window.location.reload()

      } catch (error) {
        throw "Doslo je do greske"
      }
    },
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
  box-shadow: 0 0 15px 4px rgba(0, 0, 0, 0.6);
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
