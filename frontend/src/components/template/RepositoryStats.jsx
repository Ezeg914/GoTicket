import React from "react";
import { View } from "react-native";
import StyledText from "./StyledText";


const sections = ["Empresa", "Salida", "Destino", "Comodidad", "Información"]

const RepositoryStats = () => {
    return (
      <View style={{flexDirection: 'row', justifyContent: 'space-around'}}>
        {sections.map((section) => (
            <View key={section}>
                <StyledText  fontWeight='bold'>{section}</StyledText>
            </View>
        ))}
      </View>
    );
};

export default RepositoryStats;