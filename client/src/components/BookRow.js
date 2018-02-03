import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import Title from './Title';
import Author from './Author';

export const BookRow = ({
  book: {
    id, cover, title, authors,
  }, className,
}) => (
  <Wrapper className={className}>
    <Link to={{ pathname: `/book/view/${id}` }}>
      <SmallImage src={cover} />
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

const SmallImage = styled.img`
  display: inline-block;
  height: 70px;
  margin-bottom: 8px;
`;
