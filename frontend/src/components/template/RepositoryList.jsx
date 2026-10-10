import React from "react";
import { View, Text, FlatList } from "react-native";

const RepositoryList = () => {
    return (
    <FlatList>
        ItemSeparatorComponent={() => <Text> </Text>}
        <View style={{ padding: 20, paddingBottom: 5, paddingTop: 5}}>
            <Text style={{ fontweight: 'bold', marginBottom: 5}}>city</Text>
            <Text>company</Text>
            <Text>ticket</Text>
        </View>
    </FlatList>
    )
}

export default RepositoryList