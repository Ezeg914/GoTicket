import React, { useContext, useState } from "react";
import { View, Text, Image, TouchableOpacity } from "react-native";
import styles from "../styles/Profile.styles";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { GlobalStateContext } from "../../contexts/Globalstate";

const UserProfile = ({ navigation }) => {
  const { setToken, setUser } = useContext(GlobalStateContext);

  const logout = async () => {
    await AsyncStorage.removeItem("token");
    setToken("");
    setUser(null);

    navigation.navigate("Login");
  };

  const usuario = {
    name: "Ezequiel Garcia",
    rol: "Usuario",
    email: "john.doe@example.com",
  };

  const bus = [
    {
      id: 1,
      titulo: "Reserva ",
      company: "Andesmar",
      origin: "Mendoza",
      destination: "San Rafael",
      date: "12/12/2020",
      user_id: { name: "Bruno Rosales" },
    },
    {
      id: 2,
      titulo: "Reserva ",
      company: "Andesmar",
      origin: "Mendoza",
      destination: "San Rafael",
      date: "12/12/2020",
      user_id: { name: "Ezequiel Garcia" },
    },
    // Agrega más bus según tus necesidades
  ];

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Image
          source={require("../../../assets/splash.png")}
          style={styles.avatar}
        />
        <Text style={styles.name}>{usuario.name}</Text>
        <Text style={styles.name}>{usuario.email}</Text>
      </View>
      <View style={styles.content}>
        <Text style={styles.description}></Text>
        <View style={styles.socialIcons}>
          {/* Agrega tus iconos de redes sociales aquí */}
        </View>
      </View>
      <View style={styles.bus}>
        {bus.map((bus) => (
          <View key={bus.id} style={styles.busCard}>
            <Text style={styles.busTitle}>{bus.titulo}</Text>
            <View style={styles.socialIcons}>
              {/* Agrega tus iconos de redes sociales aquí */}
            </View>
            <Text>Company: {bus.company}</Text>
            <Text>Origin: {bus.origin}</Text>
            <Text>Destination: {bus.destination}</Text>
            <Text>Date: {bus.date}</Text>
            <Text>User: {bus.user_id.name}</Text>
            <View style={styles.busButtons}>
              <TouchableOpacity style={styles.deleteButton}>
                <Text style={styles.buttonText}>Eliminar</Text>
              </TouchableOpacity>
              {/* Botones para editar y borrar bus */}
            </View>
          </View>
        ))}
      </View>
      <View
        style={{
          marginTop: 24,
        }}
      >
        <TouchableOpacity
          style={{
            fontSize: 24,
          }}
          onPress={() => logout()}
        >
          Logout
        </TouchableOpacity>
      </View>
    </View>
  );
};

export default UserProfile;
