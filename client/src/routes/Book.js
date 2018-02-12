import React, { Component } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Container, Divider, Header } from 'semantic-ui-react';
import API from '../api/Api';
import FavAPI from '../api/favs';
import { Image, Title, Author } from '../components';
import { isAdmin } from '../utils';

function FavLink({inFavs, addFav}) {
  if (inFavs) {
    return '';
  }
  return (<a href="#" id="addFav" onClick={addFav}>Добавить в заявку</a>);
}

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
    this.setState({ book: data, isAdmin: isAdmin() });
  }

  deleteBook = async () => {
    const { book } = this.state;
    const response = API.deleteBook(book.id);
    this.props.history.push('/');
  };

  addFav = async () => {
    const {book} = this.state;
    const userId = localStorage.getItem('userId');
    const response = FavAPI.createFav(book.id, userId);
    this.setState({inFavs: true});
  };

  render() {
    const { cover, title, authors, isbn, publisher, year, size, description } = this.state.book;
    const { deleteBook } = this;
    const { isAdmin, inFavs } = this.state;
    return (
      <Layout text>
        <InfoRow>
          <Link to={{ pathname: '/' }}>Назад</Link>
          {isAdmin ? (
            <a href="#" onClick={deleteBook}>
              Удалить
            </a>
          ) : null}
        </InfoRow>
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
            <RowTitle>Количество страниц</RowTitle>
            <RowContent>{size}</RowContent>
          </InfoRow>
          <InfoRow>
            <RowTitle>Количество на складе</RowTitle>
            <RowContent>{size}</RowContent>
          </InfoRow>
        </BookInfo>
        <Divider />
        <Header size="medium">Описание</Header>
        <p>{description}</p>
        <FavLink inFavs={inFavs} addFav={this.addFav} />
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
