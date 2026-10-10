import React, { useEffect, useState } from 'react';
import { View, Text, Image, TouchableOpacity, ScrollView, StyleSheet } from 'react-native';
import styles from '../styles/Bus.styles';
import StyledText from './StyledText';
import ticketApi from '../../api/ticketApi';

const BusScreen = () => {
  const [quantity, setQuantity] = useState(1);

  const increment = () => {
    setQuantity(prevQuantity => prevQuantity + 1);
  };

  const decrement = () => {
    if (quantity > 1) {
      setQuantity(prevQuantity => prevQuantity - 1);
    }
  };



  const buss = [
    {
      id: 1,
      titulo: "CATA Internacional ",
      salida: "Ciudad autonoma de Buenos Aires",
      llegada: "Mendoza",
      comodidad: "Semi Cama",
      horario: "Salida 20:00hs",
      lugares: "Disponibles: 30",
    }
  ];

 

  return (
    <ScrollView contentContainerStyle={styles.container}>
      {buss.map((bus) => (
        <View key={bus.id} style={styles.busCard}>
          <View>
            <Text style={styles.busTitle}>{bus.titulo}</Text>
            <Text style={styles.text}>Salida: {bus.salida}</Text>
            <Text style={styles.text}>Llegada: {bus.llegada}</Text>
            <Text style={styles.text}>Comodidad: {bus.comodidad}</Text>
            <Text style={styles.text}>Horario: {bus.horario}</Text>
            <Text style={styles.text}>Lugares: {bus.lugares}</Text>
            <View style={{ flexDirection: 'row', alignItems: 'center' }}>
              <TouchableOpacity onPress={decrement}>
                <Text>-</Text>
              </TouchableOpacity>
              <Text>{quantity}</Text>
              <TouchableOpacity onPress={increment}>
                <Text>+</Text>
              </TouchableOpacity>
            </View>
          </View>
          <Image source={require("../../../assets/Bus.png")} style={styles.image}/>
        </View>
      ))}
      <TouchableOpacity style={styles.button}>
        <StyledText color='bold' style={styles.button}>Comprar</StyledText>
      </TouchableOpacity>
    </ScrollView>
  );
};

export default BusScreen;
