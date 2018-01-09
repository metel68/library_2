import React, { Component } from 'react';
import styled from 'styled-components';
import { Image, Title, Author } from '../components';
import { Link } from 'react-router-dom';

class Book extends Component {
  constructor() {
    super();
    this.state = {
      book: {},
    };
  }

  async componentDidMount() {
    const { bookId } = this.props.match.params;
    const response = await fetch(`http://localhost:3004/getBook/${bookId}`);
    const data = await response.json();
    const book = data.data[0];
    this.setState({ book });
  }

  render() {
    const { coverFilename, title, authors } = this.state.book;
    return (
      <div>
        <Link to={{ pathname: '/' }}>Назад</Link>
        <Container>
          <Image src={`/img/${coverFilename}`} />
          <BookInfo>
            <Title>{title}</Title>
            {authors ? authors.map(author => <Author>{author}</Author>) : null}
          </BookInfo>
        </Container>
      </div>
    );
  }
}

const Container = styled.div`
  display: flex;
  flex-direction: row;
  max-width: 920px;
  margin: 100px auto;
`;

const BookInfo = styled.div`
  display: block;
  margin-left: 80px;
`;

export default Book;
