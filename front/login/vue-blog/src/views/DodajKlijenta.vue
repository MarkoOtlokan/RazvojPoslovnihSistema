<template>
  <div class="container">
    <div v-if="User">
      <p>Korisnik: {{ User }}</p>
    </div>
    <div>
      <form @submit.prevent="submit">
        <div>
          <label for="title">Ime:</label>
          <input type="text" name="title" v-model="form.firstName" />
        </div>
        <div>
          <label for="title">Prezime:</label>
          <input type="text" name="title" v-model="form.lastName" />
        </div>
        <div>
          <label for="title">Jmbg:</label>
          <input type="text" name="title" v-model="form.jmbg" />
        </div>
        <div>
          <label for="title">Broj telefona:</label>
          <input type="text" name="title" v-model="form.telephone" />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
    <div class="posts" v-if="Clients">
      <ul>
        <li v-for="client in Clients" :key="client.id">
          <div id="client-div">
            <p>{{ client.firstName }} {{ client.lastName }} {{ client.telephone }}</p>
          </div>
        </li>
      </ul>
    </div>
    <div v-else>Ne postoje klijenti</div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

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
  },
  computed: {
    ...mapGetters({ Clients: "StateClients", User: "StateUser" }),
  },
  methods: {
    ...mapActions(["AddClient", "GetClients"]),
    async submit() {
      try {
        console.log(this.form)
        await this.AddClient(this.form);
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
  width: 60%;
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

#client-div {
  border: 3px solid #000;
  width: 500px;
  margin: auto;
  margin-bottom: 5px;
}
</style>
