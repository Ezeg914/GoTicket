import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import { Search } from "./components/template/Search";
import MainScreen from "./components/template/Main";
import BusScreen from "./components/template/Bus";
import Profile from "./components/template/Profile";
import LoginScreen from "./components/template/Login";
import RegisterScreen from "./components/template/Register";
import { GlobalStateContext } from "./contexts/Globalstate";
import { View, Text, ActivityIndicator } from "react-native";

const Stack = createStackNavigator();

const Routes = () => {
  const { token, isLoading } = React.useContext(GlobalStateContext);

  if (isLoading) {
    return (
      <View
        style={{
          flex: 1,
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <ActivityIndicator size={36} />
        <Text style={{ fontSize: 24, marginTop: 12 }}>Loading...</Text>
      </View>
    );
  }

  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName={token ? "Search" : "Login"}>
        <Stack.Screen name="Search" component={Search} />
        <Stack.Screen name="Home" component={MainScreen} />
        <Stack.Screen name="Bus" component={BusScreen} />
        <Stack.Screen name="Profile" component={Profile} />
        <Stack.Screen
          name="Login"
          component={LoginScreen}
          options={{ headerShown: false }}
        />
        <Stack.Screen
          name="Register"
          component={RegisterScreen}
          options={{ headerShown: false }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default Routes;
