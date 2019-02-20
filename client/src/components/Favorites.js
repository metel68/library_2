import React from 'react';
import styled from 'styled-components';
import BookRow from './BookRow';
import {Header} from "semantic-ui-react";

export const Favorites = ({
  books, className, redrawParent,
}) => (
  <Wrapper className={className}>
    {books.length ? <Header>Книги на руках</Header> : null}
    {books.map((book, key) => <BookRow book={book} key={key} redrawParent={redrawParent} />)}
  </Wrapper>
);

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
`;
