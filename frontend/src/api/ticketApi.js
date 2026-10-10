import axios from "axios";
import AsyncStorage from "@react-native-async-storage/async-storage";

//base url for ticket api

const ticketApi = axios.create({
  baseURL: "http://localhost:4000",
});

ticketApi.interceptors.request.use(async (config) => {
  const token = await AsyncStorage.getItem("token");

  if (token) {
    config.headers["Authorization"] = token;
  }

  return config;
});

export default ticketApi;
