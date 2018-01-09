import React, { Component } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Container } from 'semantic-ui-react';
import API from '../Api';
import { Image, Title, Author } from '../components';

class Book extends Component {
  constructor() {
    super();
    this.state = {
      book: {},
    };
  }

  async componentDidMount() {
    const { bookId } = this.props.match.params;
    const response = await API.getBook(bookId);
    const { data } = response;
    this.setState({ book: data });
  }

  render() {
    const { cover, title, authors } = this.state.book;
    return (
      <Layout text>
        <Link to={{ pathname: '/' }}>Назад</Link>
        <BookWrapper>
          <Image src={cover} />
          <BookInfo>
            <Title>{title}</Title>
            {authors
              ? authors.map(author => <Author key={author.id}>{author.fullName}</Author>)
              : null}
          </BookInfo>
        </BookWrapper>
      </Layout>
    );
  }
}

const Layout = styled(Container)`
  margin-top: 50px;
`;

const BookWrapper = styled.div`
  display: flex;
  flex-direction: row;
  margin-top: 50px;
`;

const BookInfo = styled.div`
  display: block;
  margin-left: 80px;
`;

export default Book;
