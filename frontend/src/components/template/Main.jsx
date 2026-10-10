import React, { useState, useEffect } from "react";
import { View, Text, TouchableOpacity, ScrollView } from "react-native";
import styles from "../styles/Main.styles";
import StyledText from "./StyledText";
import ticketApi from "../../api/ticketApi";
import { GlobalStateContext } from "../../contexts/Globalstate";

const MainScreen = ({ navigation }) => {
  const { origin, destination, date, user, token } =
    React.useContext(GlobalStateContext);
  const [buses, setBuses] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);

  console.log(user, token);

  const fetchBuses = async () => {
    try {
      const params = new URLSearchParams();
      params.append("cityFrom", origin);
      params.append("cityTo", destination);
      params.append("date", date);

      const resp = await ticketApi.get("/trip", { params: params });
      setBuses(resp.data.content);
    } catch (error) {
      console.log(error);
    }
  };

  const handleBus = () => {
    navigation.navigate("Bus");
  };

  const handlePagination = (direction) => {
    if (direction === "prev" && currentPage > 1) {
      setCurrentPage(currentPage - 1);
    } else if (direction === "next" && endIndex < buss.length) {
      setCurrentPage(currentPage + 1);
    }
  };

  useEffect(() => {
    fetchBuses();
  }, []);
  [];

  return (
    <ScrollView contentContainerStyle={styles.container}>
      {buses.map((bus, i) => (
        <View key={bus.id} style={styles.busCard}>
          <Text style={styles.busTitle}>{bus.company.name}</Text>
          <View key={i}>
            <Text>Salida: {bus.city_from.name}</Text>
            <Text>Llegada: {bus.city_to.name}</Text>
            <Text>Hora: {bus.date}</Text>
            <TouchableOpacity onPress={handleBus} style={styles.button}>
              <StyledText color="bold" style={styles.button}>
                Comprar
              </StyledText>
            </TouchableOpacity>
          </View>
        </View>
      ))}
    </ScrollView>
  );
};

export default MainScreen;
