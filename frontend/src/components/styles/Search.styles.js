import { StyleSheet } from 'react-native';

const styles = StyleSheet.create({
    outerContainer: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#B9F3E4",
    },
    iconContainer: {
        marginBottom: 20,
       alignItems: "center",
    },
    container: {
        width: '80%',
        backgroundColor: '#fff',
        padding: 20,
        borderRadius: 10,
        alignItems: 'center',
    },
    title1: {
        fontSize: 30,
        fontWeight: "bold",
        marginBottom: 30,
        color: "#BA55D3"
    },
    title2: {
        fontSize: 30,
        fontWeight: "bold",
        marginBottom: 20,
    },

    input: {
        width: '100%',
        height: 40,
        borderColor: 'gray',
        borderWidth: 1,
        marginBottom: 10,
        paddingHorizontal: 10,
    },
    roundButton: {
        backgroundColor: "#9036bb",
        borderRadius: 50,
        paddingHorizontal: 20,
        paddingVertical: 10,
        marginTop: 10,
        flexDirection: "row",
        alignItems: "center",
        justifyContent: "center",
    },
    profileButtonContainer: {
        position: "absolute",
        top: 0,
        right: 9,
        marginTop: 10,
        marginright: 100,
    },
});

export default styles;