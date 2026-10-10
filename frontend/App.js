import React from 'react';
import Routes from './src/navigation';
import { GlobalStateProviders } from './src/contexts/Globalstate';

export default function App() {
  return (
    <GlobalStateProviders>
      <Routes />
    </GlobalStateProviders>
  );
}


