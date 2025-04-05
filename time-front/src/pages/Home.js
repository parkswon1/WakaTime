import React from 'react';
import styled from 'styled-components';

const HomeContainer = styled.div`
  padding: 20px;
  max-width: 1200px;
  margin: 0 auto;
`;

const Title = styled.h1`
  color: #333;
  text-align: center;
`;

function Home() {
  return (
    <HomeContainer>
      <Title>Welcome to Time Management</Title>
    </HomeContainer>
  );
}

export default Home; 