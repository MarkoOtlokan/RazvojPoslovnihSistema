import axios from "axios";

const state = {
  user: null,
  clients: null,
  products: null,
  bestCustomers: null,
};

const getters = {
  isAuthenticated: (state) => !!state.user,
  StateClients: (state) => state.clients,
  StateProducts: (state) => state.products,
  StateUser: (state) => state.user,
  StateSales: (state) => state.sales,
  StateBestCustomers: (state) => state.bestCustomers,
};

const actions = {
  async Register({dispatch}, form) {
    await axios.post('register', form)
    let UserForm = new FormData()
    UserForm.append('username', form.username)
    UserForm.append('password', form.password)
    await dispatch('LogIn', UserForm)
  },

  async LogIn({commit}, user) {
    await axios.post("login", user);
    await commit("setUser", user.get("username"));
  },

  async AddClient({ dispatch }, client) {
    await axios.post("http://localhost:8080/api/customers", client);
    return await dispatch("GetClients");
  },

  async GetClients({ commit }) {
    let response = await axios.get("http://localhost:8080/api/customers");
    commit("setClients", response.data);
  },

  async AddProduct({ dispatch }, product) {
    await axios.post("http://localhost:8080/api/article", product);
    return await dispatch("GetProducts");
  },

  async GetProducts({ commit }) {
    let response = await axios.get("http://localhost:8080/api/article");
    commit("setProducts", response.data);
  },

  async AddSale({ dispatch }, sale) {
    await axios.post("http://localhost:8080/api/sales?" + "customerId=" + sale.customerId + "&articleId=" + sale.articleId + "&amount=" + sale.amount);
    return await dispatch("GetSales");
  },

  async GetSales({ commit }) {
    let response = await axios.get("http://localhost:8080/api/sales");
    commit("setSales", response.data);
  },

  async GetBestCustomers({ commit }) {
    let response = await axios.get("http://localhost:8080/api/sales/bestcustomers");
    commit("setBestCustomers", response.data);
    console.log(response.data)
  },

  async LogOut({ commit }) {
    let user = null;
    commit("logout", user);
  },
};

const mutations = {
  setUser(state, username) {
    state.user = username;
  },

  setClients(state, clients) {
    state.clients = clients;
  },
  setProducts(state, products) {
    state.products = products;
  },
  setSales(state, sales) {
    state.sales = sales;
  },
  setBestCustomers(state, bestCustomers) {
    state.bestCustomers = bestCustomers;
  },
  logout(state, user) {
    state.user = user;
  },
};

export default {
  state,
  getters,
  actions,
  mutations,
};
