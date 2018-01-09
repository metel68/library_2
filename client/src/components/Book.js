import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import Image from './Image';
import Title from './Title';
import Author from './Author';

export const Book = ({
  book: {
    id, coverFilename, title, authors,
  }, className,
}) => (
  <Wrapper className={className}>
    <Link to={{ pathname: `book/view/${id}` }}>
      <Image src={`/img/${coverFilename}`} />
    </Link>
    <Title>{title}</Title>
    {authors.map(author => <Author key={`${id}${author}`}>{author}</Author>)}
  </Wrapper>
);

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
`;
