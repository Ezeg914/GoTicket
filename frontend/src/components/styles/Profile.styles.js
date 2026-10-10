import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    container: {
      flex: 1,
      padding: 25,
      backgroundColor: "#B9F3E4",
    },
    header: {
      alignItems: "center",
      marginBottom: 16,
      marginTop: 55,
    },  
    avatar: {
      marginBottom: 10,
      width: 100,
      height: 100,
      borderRadius: 50,
    },
    name: {
      fontSize: 24,
      fontWeight: "bold",
      marginBottom: 0,
      color: "#fff",
    },
    content: {
      marginBottom: 0,
    },
    description: {
      marginBottom: 0,
    },
    socialIcons: {
      flexDirection: "row",
      marginBottom: 1,
    },
    deleteButton: {
      backgroundColor: "#9036bb",
      paddingVertical: 8,
      paddingHorizontal: 16,
      borderRadius: 4,
      alignItems: "center",
    },
    buttonText: {
      color: "#fff",
    },
    bus: {
      flexDirection: "column",
    },
    busCard: {
      borderColor: "#ccc",
      padding: 8,
      marginBottom: 8,
      backgroundColor: "#fff",
    },
    busTitle: {
      fontSize: 18,
      fontWeight: "bold",
      marginBottom: 4,
    },
    busButtons: {
      flexDirection: "row",
      justifyContent: "flex-end",
    },
  });

export default styles;