<template>
  <div class="container">
    <div v-if="User">
      <p>Korisnik: {{ User }}</p>
    </div>
    <div>
      <form @submit.prevent="submit">
        <div>
          <label for="title">Naziv:</label>
          <input type="text" name="title" v-model="form.name" />
        </div>
        <div>
          <label for="title">Namena:</label>
          <input type="text" name="title" v-model="form.type" />
        </div>
        <div>
          <label for="title">Cena:</label>
          <input type="text" name="title" v-model="form.price" />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
    <div class="posts" v-if="Products">
      <ul>
        <li v-for="product in Products" :key="product.id">
          <div id="product-div">
            <p>{{ product.name }} {{ product.type }} {{ product.price }}</p>
          </div>
        </li>
      </ul>
    </div>
    <div v-else>Ne postoje proizvodi</div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  name: "AddProduct",
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
    this.GetProducts()
  },
  computed: {
    ...mapGetters({ Products: "StateProducts", User: "StateUser" }),
  },
  methods: {
    ...mapActions(["AddProduct", "GetProducts"]),
    async submit() {
      try {
        await this.AddProduct(this.form);
      } catch (error) {
        throw "Sorry you can't make a post now!"
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

#product-div {
  border: 3px solid #000;
  width: 500px;
  margin: auto;
  margin-bottom: 5px;
}
</style>
