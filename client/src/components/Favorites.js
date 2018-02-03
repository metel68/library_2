import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { BookRow } from './BookRow';

export const Favorites = ({
  books, className,
}) => (
  <Wrapper className={className}>
    {books.map(book => <BookRow book={book} />)}
  </Wrapper>
);

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
`;
