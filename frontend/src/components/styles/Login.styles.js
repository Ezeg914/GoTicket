import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    container: {
      flex: 1,
      padding: 20,
      backgroundColor: "#B9F3E4",
    },
    form: {
      padding: 16,
      borderRadius: 14,
      backgroundColor: '#fff'
    },
    header: {
      alignItems: "center",
      marginBottom: 16,
      marginTop: 55,
    },  
    content: {
      marginBottom: 0,
      padding: 8,
    },
    description: {
      fontSize: 15,
      fontWeight: "bold",
      marginBottom: 20,
      alignContent: "center",
      color: "#ffff"
    },
    title1: {
      fontSize: 35,
      fontWeight: "bold",
      marginBottom: 20,
      marginTop: 10,
      color: "#BA55D3"
    },
    title2: {
      fontSize: 30,
      fontWeight: "bold",
      marginBottom: 20,
    },
    titleemail: {
      fontSize: 15,
      fontWeight: "bold",
      marginBottom: 10,
      marginTop: 0,
      borderRadius: 12,
    },
    titlepassword: {
      fontSize: 15,
      fontWeight: "bold",
      marginBottom: 10,
      marginTop: 5,
      paddingTop: 25,
      borderRadius: 12,

    },
    registercard: {
      borderColor: "#ccc",
      padding: 10,
      marginBottom: 8,
      paddingTop: 25,
    },
    buttonlogin: {
      backgroundColor: "#8BC34A",
      borderRadius: 12,
      padding: 25,
      paddingTop: 25,
      marginTop: 25,
    },
    buttonText: {
      color: "#fff",
      fontSize: 20,
      fontWeight: "bold",
      textAlign: "center",
    },
    description: {
      fontSize: 15,
      fontWeight: "bold",
      marginBottom: 5,
      alignContent: "center",
      color: "#000"
    },
    descriptionaccount: {
      fontSize: 18,
      fontWeight: "bold",
      paddingTop: 15,
      marginBottom: 25,
      color: "#000",
      textAlign: "center",
    },
    textregister: {
      color: "#ab00f3",
      fontSize: 20,
      fontWeight: "bold",
      textAlign: "center",
      textDecorationLine: 'underline'
    },
    buttonregister: {
      borderRadius: 12,
      padding: 25,
      paddingTop: 15,
      marginTop: 10,
      width: 150,
      alignSelf: "center",
    },
  });

export default styles;