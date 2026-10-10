//globalstate
import AsyncStorage from "@react-native-async-storage/async-storage";
import React, { useState, createContext, useEffect } from "react";
import ticketApi from "../api/ticketApi";

const GlobalStateContext = createContext();

const GlobalStateProviders = ({ children }) => {
  const [origin, setOrigin] = useState("");
  const [destination, setDestination] = useState("");
  const [date, setDate] = useState("");
  const [user, setUser] = useState(null);
  const [token, setToken] = useState("");
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const getToken = async () => {
      const token = (await AsyncStorage.getItem("token")) || "";
      setToken(token);

      setTimeout(
        () => {
          setIsLoading(false);
        },
        token ? 1000 : 0
      );
    };
    getToken();
  }, []);

  const value = {
    isLoading,
    user,
    setUser,
    token,
    setToken,
    origin,
    setOrigin,
    destination,
    setDestination,
    date,
    setDate,
  };

  return (
    <GlobalStateContext.Provider value={value}>
      {children}
    </GlobalStateContext.Provider>
  );
};

export { GlobalStateContext, GlobalStateProviders };
