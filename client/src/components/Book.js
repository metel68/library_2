import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import Image from './Image';
import Title from './Title';
import Author from './Author';

export const Book = ({
  book: {
    id, cover, title, authors,
  }, className,
}) => (
  <Wrapper className={className}>
    <Link to={{ pathname: `/book/view/${id}` }}>
      <Image src={cover} />
    </Link>
    <Title>{title}</Title>
    {authors.map(author => (
      <Author key={`${author.id}${author.fullName}`}>{author.fullName}</Author>
    ))}
  </Wrapper>
);

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
`;
