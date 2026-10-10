import React, { useContext, useState } from "react";
import { View, Text, TouchableOpacity } from "react-native";
import styles from "../styles/Login.styles";
import { TextInput } from "react-native-paper";
import Icon from "react-native-vector-icons/Ionicons";
import AsyncStorage from "@react-native-async-storage/async-storage";
import ticketApi from "../../api/ticketApi";
import { Alert } from "react-native";
import { GlobalStateContext } from "../../contexts/Globalstate";

const LoginScreen = ({ navigation }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const { setUser, setToken } = useContext(GlobalStateContext);

  const handleLogin = async () => {
    
    try {
      const resp = await ticketApi.post("/login", {
        email,
        password,
      });

      const { access_token } = resp.data.data;
      const { id } = resp.data.data;

      const userData = await ticketApi.get(`/user/${id}`);
      setUser(userData.data);
      setToken(access_token);

      //despues de un inicio exitoso, guardamos el token en el storage
      await AsyncStorage.setItem("token", access_token);
      navigation.navigate("Search");
    } catch (error) {
      Alert.alert("Error", "Email or password incorrect");
      console.log(error);
    }
  };

  const handleRegister = () => {
    navigation.navigate("Register");
  };

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Icon name="ios-bus" size={80} color="#BA55D3" />
        <Text style={styles.title1}>GoTicket</Text>
      </View>
      <View style={styles.form}>
        <View style={styles.registercard}>
          <Text style={styles.titleemail}>Email</Text>
          <TextInput
            placeholder="Enter your email"
            value={email}
            onChangeText={(text) => setEmail(text)} // Corrección: Utiliza onChangeText en lugar de onChange
          />
          <Text style={styles.titlepassword}>Password</Text>
          <TextInput
            value={password}
            onChangeText={(text) => setPassword(text)} // Corrección: Utiliza onChangeText en lugar de onChange
          />
          <TouchableOpacity
            onPress={() => handleLogin()}
            style={styles.buttonlogin}
            activeOpacity={0.7}
          >
            <Text style={styles.buttonText}>Log in</Text>
          </TouchableOpacity>
          <Text style={styles.descriptionaccount}>
            Don't you have an account?
          </Text>
          <TouchableOpacity
            onPress={handleRegister}
            style={styles.buttonregister}
          >
            <Text style={styles.textregister}>Register</Text>
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
};

export default LoginScreen;
