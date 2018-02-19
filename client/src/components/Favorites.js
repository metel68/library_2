import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import BookRow from './BookRow';

export const Favorites = ({
  books, className, redrawParent,
}) => (
  <Wrapper className={className}>
    {books.map((book, key) => <BookRow book={book} key={key} redrawParent={redrawParent} />)}
  </Wrapper>
);

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
`;
