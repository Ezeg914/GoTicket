import React, { useState } from "react";
import { Text, View, TextInput, TouchableOpacity } from "react-native";
import Icon from "react-native-vector-icons/Ionicons";
import styles from "../styles/Search.styles";
import StyledText from "./StyledText";
import { GlobalStateContext } from "../../contexts/Globalstate";

export const Search = ({ navigation }) => {
  const {
    origin,
    setOrigin,
    destination,
    setDestination,
    date,
    setDate,
    user,
    token,
  } = React.useContext(GlobalStateContext);

  const handleBuscar = async () => {
    try {
      console.log("Origin: ", origin);
      console.log("Destination: ", destination);
      console.log("Date: ", date);
      navigation.navigate("Home");
    } catch (error) {
      console.log("Error: ", error);
    }
  };

  const handlePerfil = () => {
    navigation.navigate("Profile");
  };

  return (
    <View style={styles.outerContainer}>
      <View style={styles.profileButtonContainer}>
        <TouchableOpacity onPress={handlePerfil} style={styles.roundButton}>
          <Icon name="ios-person" size={25} color="#fff" />
          <StyledText color="body" style={styles.button}>
            {" "}
            Profile
          </StyledText>
        </TouchableOpacity>
      </View>
      <View style={styles.iconContainer}>
        <Icon name="ios-bus" size={80} color="#BA55D3" />
        <Text style={styles.title1}>GoTicket</Text>
      </View>

      <View style={styles.container}>
        <Text style={styles.title2}>Where we go?</Text>

        <TextInput
          style={styles.input}
          placeholder="Ciudad de Origen"
          value={origin}
          onChangeText={(text) => setOrigin(text)}
        />
        <TextInput
          style={styles.input}
          placeholder="Ciudad de Destino"
          value={destination}
          onChangeText={(text) => setDestination(text)}
        />
        <TextInput
          style={styles.input}
          placeholder="Fecha de Viaje"
          value={date}
          onChangeText={(text) => setDate(text)}
        />

        <TouchableOpacity onPress={handleBuscar} style={styles.roundButton}>
          <Icon name="ios-search" size={25} color="#fff" />
        </TouchableOpacity>
      </View>
    </View>
  );
};
