import React, { Component } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Container, Divider, Header } from 'semantic-ui-react';
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
    const {
      cover, title, authors, isbn, publisher, year, size, description,
    } = this.state.book;
    return (
      <Layout text>
        <Link to={{ pathname: '/' }}>Назад</Link>
        <BookWrapper>
          <Image src={cover} />
          <BookTitle>
            <Title>{title}</Title>
            {authors
              ? authors.map(author => <Author key={author.id}>{author.fullName}</Author>)
              : null}
          </BookTitle>
        </BookWrapper>
        <Divider />
        <BookInfo>
          <InfoRow>
            <RowTitle>ISBN</RowTitle>
            <RowContent>{isbn}</RowContent>
          </InfoRow>
          <InfoRow>
            <RowTitle>Издатель</RowTitle>
            <RowContent>{publisher ? publisher.name : ''}</RowContent>
          </InfoRow>
          <InfoRow>
            <RowTitle>Год издания</RowTitle>
            <RowContent>{year}</RowContent>
          </InfoRow>
          <InfoRow>
            <RowTitle>Колличество страниц</RowTitle>
            <RowContent>{size}</RowContent>
          </InfoRow>
          <InfoRow>
            <RowTitle>Колличество на складе</RowTitle>
            <RowContent>{size}</RowContent>
          </InfoRow>
        </BookInfo>
        <Divider />
        <Header size="medium">Описание</Header>
        <p>{description}</p>
      </Layout>
    );
  }
}

const RowTitle = styled.span`
  color: #888;
`;

const RowContent = styled.span`
  color: #000;
`;

const InfoRow = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`;

const BookInfo = styled.div`
  display: flex;
  flex-direction: column;
`;

const Layout = styled(Container)`
  margin-top: 50px;
  margin-bottom: 150px;
`;

const BookWrapper = styled.div`
  display: flex;
  flex-direction: row;
  margin-top: 50px;
`;

const BookTitle = styled.div`
  display: block;
  margin-left: 80px;
`;

export default Book;
