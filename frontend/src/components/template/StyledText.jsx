import React from "react";
import { Text,StyleSheet } from "react-native";
import theme from "../../theme";

const stylesText = StyleSheet.create({
    text: {
        fontSize: theme.fontSizes.body,
        color: theme.colors.textPrimary,
        fontFamily: theme.fonts.main,
        fontWeight: theme.fontWeights.normal,
    },
    colorPrimary: {
        color: theme.colors.primary,
    },
    colorSecondary: {
        color: theme.colors.secondary,
    },
    bold: {
        fontWeight: theme.fontWeights.bold,
    },
    big: {
        fontSize: theme.fontSizes.heading,
    },
});

//reusable component for text
export default function StyledText({ children, fontSize, color, fontWeight,
style, ...restOfProps }) {
    const textstyle = [
        stylesText.text,
        color === "primary" && stylesText.colorPrimary,
        color === "secondary" && stylesText.colorSecondary,
        fontSize === "heading" && stylesText.big,
        fontWeight === "bold" && stylesText.bold
    ];

    return (
        <Text style={textstyle} {...restOfProps}>
            {children}
        </Text>
    );
}